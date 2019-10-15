package mail;

/**
 * @author CNan
 */
public interface Protocol {
    interface Test{
        class Input{
            private String name;

            private String email;

            public String getName() {
                return name;
            }

            public Input setName(String name) {
                this.name = name;
                return this;
            }

            public String getEmail() {
                return email;
            }

            public Input setEmail(String email) {
                this.email = email;
                return this;
            }
        }
    }
}
