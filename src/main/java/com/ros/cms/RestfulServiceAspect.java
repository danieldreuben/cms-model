package com.ros.cms;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import java.lang.StringBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.stream.Stream;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
@Aspect
@Component
public class RestfulServiceAspect {

    @Before("execution(* com.ros.cms..*(..))")
    public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
        System.out.println(">>AOP-Before>>" + pjp);
        //System.out.println("Principal: " +  SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        //System.out.println("Authorities.."+ SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    }

    @AfterReturning(
            pointcut="execution(* com.ros..*(..))",
            returning="retVal")
        public void doAccessCheck(Object retVal) {
    		if (retVal != null)
    			System.out.println("=> " + retVal.toString());
       	}

    @AfterThrowing(
           pointcut="execution(* com.ros.cms..*(..))",
           throwing="e")
    public void doRecoveryActions(JoinPoint joinPoint, Throwable e) {
       System.err.println("entering: " + joinPoint);
       System.err.println("  w/args: " + joinPoint.getArgs().toString());
       System.err.println("      at: " + joinPoint.getSourceLocation());

       Arrays.stream(joinPoint.getArgs())
        .forEach(t -> System.err.println(" =>" + t.toString()));
        //Arrays.stream(new String[] = {"1","2","3"})
         //.forEach(t -> System.err.println(" =>" + t.toString()));
        //System.out.println(">>>ExceptonAspect>>>" + ex.getMessage());
    }

    /*
        @Around("execution(* com.ros.cms..*(..))")
        public void logAroundMethods(JoinPoint pjp) throws Throwable {
            Object[] args = pjp.getArgs();
            StringBuffer sb = new StringBuffer(
              ">>> AOP Around methods >>> "
            );

        		for (int i = 0; i < args.length; i++) {
        			Object o = args[i];
        			sb.append("'" + o + "'");
        			sb.append((i == args.length - 1) ? "" : ", ");
        		}
        		sb.append("]");

        		System.out.println(pjp.getSignature().getName() + " => " + sb.toString());
        }
    */
}
