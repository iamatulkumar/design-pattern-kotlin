package builder;

class AccountBuilder {
    private long id;
    private String mail;
    private String name;
    private boolean isAdmin;
    private String language;

    public long getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getLanguage() {
        return language;
    }

    private AccountBuilder(Builder builder) { // The constructor is private and only called by the Builder
        id = builder.id;
        mail = builder.mail;
        name = builder.name;
        isAdmin = builder.isAdmin;
        language = builder.language;
    }

    @Override
    public String toString() {
        return "AccountBuilder{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", name='" + name + '\'' +
                ", isAdmin=" + isAdmin +
                ", language='" + language + '\'' +
                '}';
    }

    public static final class Builder {

        private long id;
        private String mail;
        private String name;
        private boolean isAdmin = false; // Our Builder sets the default values now
        private String language = "en";

        public static Builder newInstance()
        {
            return new Builder();
        }

        public Builder() {}

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder isAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public AccountBuilder build() {
            return new AccountBuilder(this);
        }
    }
}



