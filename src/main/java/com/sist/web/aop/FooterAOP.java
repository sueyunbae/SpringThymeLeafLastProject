package com.sist.web.aop;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.web.service.FoodService;
import com.sist.web.vo.FoodVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class FooterAOP {

    private final FoodService fService;

    @After("execution(* com.sist.web.controller.*Controller.*(..))")
    public void after() {

        ServletRequestAttributes attr =
            (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attr != null) {
            HttpServletRequest request = attr.getRequest();
            List<FoodVO> fList = fService.foodTop10Data();
            request.setAttribute("fList", fList);
        }
    }
}
