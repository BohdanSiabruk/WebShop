package filter;


import filter.gzip.GZipServletResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GZipFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (isPossibleEncoding(req)) {
            resp.addHeader("Content-Encoding", "gzip");
            try (GZipServletResponseWrapper gzipResponse = new GZipServletResponseWrapper(resp)) {
                chain.doFilter(req, gzipResponse);
            }
        } else {
            chain.doFilter(req, resp);
        }
    }

    private boolean isPossibleEncoding(HttpServletRequest request) {
        String acceptEncoding = request.getHeader("Accept-Encoding");
        return acceptEncoding != null && acceptEncoding.contains("gzip");
    }

    @Override
    public void destroy() {
    }
}