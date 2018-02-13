package com.roticenter.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect 
public class RotiCenterDaoAdvice {
	final static Logger logger = Logger.getLogger(com.roticenter.dao.RotiCenterDaoImpl.class);
	
	 @AfterThrowing(  
             pointcut = "execution(* com.roticenter.dao.RotiCenterDaoImpl.*(..))",  
             throwing= "error")  
               
   public void myadvice(JoinPoint jp,Throwable error)//it is advice  
   {  
       logger.debug("additional concern");  
       logger.debug("Method Signature: "  + jp.getSignature());  
       logger.error("Exception is: "+error);  
       logger.debug("end of after throwing advice...");  
   }    

}
