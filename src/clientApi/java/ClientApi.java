package clientApi.java;

import java.util.List;

public class ClientApi {
    public static class Client {
        private final PersonalInfo personalInfo;
        private final List<Order> orders;
        private final boolean isInterestedInSpam;

        public Client(PersonalInfo personalInfo, List<Order> orders, boolean isInterestedInSpam) {
            this.isInterestedInSpam = isInterestedInSpam;
            this.personalInfo = personalInfo;
            this.orders = orders;
        }

        public PersonalInfo getPersonalInfo() {
            return personalInfo;
        }

        public List<Order> getOrders() {
            return orders;
        }

        public boolean isInterestedInSpam() {
            return isInterestedInSpam;
        }
    }

    public static class PersonalInfo {
        private final String name;
        private final String email;

        public PersonalInfo(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    public interface Order {}
}


