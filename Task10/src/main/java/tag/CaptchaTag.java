package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

import static constant.Constants.TAG_CAPTCHA_ID;

public class CaptchaTag extends TagSupport {

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("<ul class=\"actions\">\n");

            String id_captcha ;

            id_captcha = (String) pageContext.getSession().getAttribute(TAG_CAPTCHA_ID);

            out.print("<li id=\"captcha_confirm\" class=\"captcha\">\n" +
                    "<img src=\"captcha\" id=\"id_captcha\" value=\"" + id_captcha + "\"/>\n" +
                    "</li>\n" +
                    "</ul>");
            id_captcha = (String) pageContext.getServletContext().getAttribute(TAG_CAPTCHA_ID);
            out.print("<input type=\"hidden\" id=\"hidden\" name=\"hidden\" value=\"" + id_captcha + "\"/>");
            out.flush();

        } catch (IOException e) {
            e.getStackTrace();
        }

        return SKIP_BODY;
    }
}