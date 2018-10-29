public class Main {

    public static void main(String[] args) {
        EmailMessage Email = new EmailMessage.Builder()
                .toWho("inny.mail@agh.pl")
                .fromWho("jakis.mail@wp.pl")
                .setSubject("naglowek")
                .setContent("zawartosc")
                .build();
    }
}