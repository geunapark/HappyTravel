package com.trip.happytravel.common.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE) // 가장 높은 우선순위로 실행
public class MDCFilter implements Filter {

    //요청과 응답을 로깅하는 법
    // HTTP 요청 수신을 받고 클라리언트에서 서버로 들어오는 req를 필터에서 가로챔 ->필터에서 req 정보 로깅
    //필터 체인을 통해 컨트롤러로 요청을 넘김 -> 필터에서 컨트롤러 응답을 다시 가로챔 resp 로깅
    //응답 반환

    //MDC를 사용할 때
    //요청이 들어오면 요청 ID를 MDC에 저장
    //다음 필터나 컨트롤러에 요청 전달
    //응답 후 MDC를 정리한다 (MDC 정보를 제거하는 이유는 메모리 누수를 방지한다)


    //Logger를 이용하고 log와 관련된 로거가 생성
    private static final Logger log = LoggerFactory.getLogger(MDCFilter.class);


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // HttpServletRequest와 HttpServletResponse로 다운캐스팅
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 요청 ID 생성 및 MDC에 저장
        String reqId = UUID.randomUUID().toString();
        MDC.put("reqId", reqId);
        MDC.put("clientIp", request.getRemoteAddr()); // 클라이언트 IP 저장

        try {
            // 요청 로그 출력
            log.info("Incoming Request: {} {} from IP: {}",
                    httpRequest.getMethod(), httpRequest.getRequestURI(), httpRequest.getRemoteAddr());

            // 다음 필터로 요청 전달
            chain.doFilter(request, response);

            // 응답 로그 출력
            log.info("Response: Status {}", httpResponse.getStatus());

        } finally {
            // MDC 정보 제거 (메모리 누수 방지)
            MDC.clear();
        }
    }
}
