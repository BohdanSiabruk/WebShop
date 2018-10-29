package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class LoginTag extends SimpleTagSupport {
    private String email;
    private String firstName;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String getFirstName(){
        return firstName ;
    }

    private String getAvatar(){
        return "<img class=\"img\" src=\"avatar?email=" + email + "\"width=\"30\" height=\"30\">";
    }

    private String getLogout(){
        return "<a href=\"/logout\">LOGOUT</a>";
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write( getAvatar() + "\n" + getFirstName() + "  "+ getLogout());

    }
}
