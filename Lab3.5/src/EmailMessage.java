
import java.util.LinkedList;

public class EmailMessage {

    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    //private LinkedList<String> cc; //optional
    //private LinkedList<String> bcc; // optional

    private EmailMessage( Builder builder){
        if (builder == null) {
            return;
        }
        from = builder.from;
        to = builder.to;
        subject = builder.subject;
        content = builder.content;
        mimeType = builder.mimeType;
    }
    public static class Builder{
        private String from = new String();
        private LinkedList<String> to;
        private String subject = new String();
        private String content = new String();
        private String mimeType = new String();

        public Builder fromWho(String f){
            if(f.length()!=0) {
                from = f;
            }
            return this;
        }
        public Builder toWho(String t){
            to = new LinkedList<String>();
            if(t.length()!=0) {
                to.add(t);
            }
            return this;
        }
        public Builder setSubject(String s){
            if(s.length()!=0 && !subject.equals(s)) {
                subject = s;
            }
            return this;
        }
        public Builder setContent(String c){
            content = c;
            return this;
        }
        public Builder setMimetype(String m){
            mimeType=m;
            return this;
        }
        /*public Builder setcc (LinkedList<String> CC){
            if(!cc.equals(CC)){
                cc=CC;
            }
            return this;
        }
        public Builder setbcc (LinkedList<String> BCC){
            if(!bcc.equals(BCC)){
                bcc=BCC;
            }
            return this;
        }*/
        public EmailMessage build(){
            return new EmailMessage(this);
        }
    }
}