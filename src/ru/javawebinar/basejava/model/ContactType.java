package ru.javawebinar.basejava.model;

public enum Contacts {
    PHONE("Тел.:") {
        String contactInfo;

        @Override
        void setContactInfo(ArrayList<String> contactInfoList) {
            contactInfo = contactInfoList.get(PHONE.ordinal());
        }

        @Override
        String getContactInfo() {
            return contactInfo;
        }
    },
    SKYPE("Skype:") {
        @Override
        public String getContactInfo() {
            return "Hangman'sCustomer";
        }

        @Override
        String getContactInfo() {
            return contactInfo;
        }
    },
    MAIL("Почта:") {
        @Override
        public String getContactInfo() {
            return "anotherdawnrises@gmail.com";
        }

        @Override
        String getContactInfo() {
            return contactInfo;
        }
    },
    LINKED_IN("профиль LinkedIn:") {
        @Override
        public String getContactInfo() {
            return "Egor's LinkedIn profile";
        }

        @Override
        String getContactInfo() {
            return contactInfo;
        }
    },
    GITHUB("Профиль GitHub:") {
        @Override
        public String getContactInfo() {
            return "https://github.com/HangmanCustomer";
        }

        @Override
        String getContactInfo() {
            return contactInfo;
        }
    },
    STACK_OVER_FLOW("Профиль StackOverFlow:") {
        @Override
        public String getContactInfo() {
            return "https://stackoverflow.com/users/10303676/hangmanscustomer";
        }

        @Override
        String getContactInfo() {
            return contactInfo;
        }
    },
    HOME_PAGE("Домашняя страница:") {
        String contactInfo;

        @Override
        void setContactInfo(ArrayList<String> contactInfoList) {
            contactInfo = contactInfoList.get(HOME_PAGE.ordinal());
        }

        @Override
        String getContactInfo() {
            return contactInfo;
        }
    };

    private String value;

    Contacts(String value) {
        this.value = value;
    }

    public String getRuValue() {
        return ruValue;
    }

    public abstract String getContactInfo();

}
