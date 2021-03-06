package com.jk.aop;


import com.jk.model.Logs;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Date;

//声明是一个切面: 添加 @Aspect
// * 切面必须是 IOC 中的 bean: 实际添加了 @Component 注解
@Aspect
@Component
public class WebLogAspect {
    @Autowired
    private MongoTemplate mongoTemplate;
    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    /**
     * 定义一个切入点表达式,用来确定哪些类需要代理
     * execution(* aopdemo.*.*(..))代表aopdemo包下所有类的所有方法都会被代理
     */
    @Pointcut("execution(public * com.jk.service..*Impl.*(..))")
    public void webLog() {
    }

    /**
     * 前置方法,在目标方法执行前执行
     *
     * @param joinPoint 封装了代理方法信息的对象,若用不到则可以忽略不写
     */
    @Before("webLog()")
   public void doBefore(JoinPoint joinPoint) throws Throwable {
    //HttpServletRequest request =
        System.out.println("进入前置通知");

    }


    //返回通知:在方法正常结束后执行的代码，返回通知是可以访问到方法的返回值的！！！
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("处理完请求，返回内容 : " + ret);
    }

    //后置通知：在目标方法执行后（无论是否发生异常），执行的通知
    //注意，在后置通知中还不能访问目标执行的结果!!!，执行结果需要到返回通知里访问
    @After("webLog()")
    public void doAfterReturning(JoinPoint joinPoint) throws Throwable {
       /* ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();*/
        // 处理完请求，返回内容
        System.out.println("进入后置通知切面");
        Logs logs = new Logs();
        Date now = new Date();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String time = sim.format(now);
        System.out.println("调用时间:" + time);
        // 接收到请求，记录请求内容
        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        String param = "";
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            String a = "第" + (i + 1) + "个参数为:" + args[i];
            param += a;
        }
        if(args.length ==0 ){
            param = "没有参数";
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("代理对象自己:" + joinPoint.getThis());
        logs.setClazzName(Modifier.toString(joinPoint.getSignature().getModifiers()));
        logs.setMethodName(joinPoint.getSignature().getName());
        logs.setParams(param);
        logs.setException("正常");
        //暂时logs的用户写成"测试人员",后面再改
        mongoTemplate.save(logs);
    }
    //异常通知：在目标方法出现异常 时会执行的代码，可以访问到异常对象：且可以!!指定在出现特定异常时在执行通知!!,如果是修改为nullPointerException里，只有空指针异常才会执行
    //    @AfterThrowing(pointcut = "execution(* Spring4_AOP.aopAnnotation.*.*(..))", throwing = "except")
    @AfterThrowing(value = "webLog())", throwing = "except")
    public void afterThrowing(JoinPoint joinPoint, Exception except) {

        String methodName = joinPoint.getSignature().getName();
        String exception  = "当前: " + methodName + " 方法,发生 " + except+"异常";
        System.out.println(exception);
        Logs logs = new Logs();
        Date now = new Date();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String time = sim.format(now);
        System.out.println("调用时间:" + time);
        // 接收到请求，记录请求内容
        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        String param = "";
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            String a = "第" + (i + 1) + "个参数为:" + args[i];
            param += a;
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("代理对象自己:" + joinPoint.getThis());
        logs.setClazzName(Modifier.toString(joinPoint.getSignature().getModifiers()));
        logs.setMethodName(joinPoint.getSignature().getName());
        logs.setParams(param);
        logs.setException(exception);
        //暂时logs的用户写成"测试人员",后面再改
        mongoTemplate.save(logs);
    }

}