package builder;

public class ApplicationBuilder {
    public static void main(String[] args) {
        AccountBuilder accountBuilder = AccountBuilder.Builder.newInstance()
                .id(1)
                .name("atul")
                .mail("meial@gojek.com")
                .isAdmin(true)
                .language("cece")
                .build();
        System.out.println(accountBuilder.getName());
    }
}
