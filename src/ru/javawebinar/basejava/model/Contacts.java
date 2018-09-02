package ru.javawebinar.basejava.model;

public enum Contacts {
    PHONE("Тел.:") {
        @Override
        public String getContactInfo() {
            return "555-55-55";
        }
    },
    SKYPE("Skype:") {
        @Override
        public String getContactInfo() {
            return "Hangman'sCustomer";
        }
    },
    MAIL("Почта:") {
        @Override
        public String getContactInfo() {
            return "anotherdawnrises@gmail.com";
        }
    },
    LINKED_IN("профиль LinkedIn:") {
        @Override
        public String getContactInfo() {
            return "Egor's LinkedIn profile";
        }
    },
    GITHUB("Профиль GitHub:") {
        @Override
        public String getContactInfo() {
            return "https://github.com/HangmanCustomer";
        }
    },
    STACK_OVER_FLOW("Профиль StackOverFlow:") {
        @Override
        public String getContactInfo() {
            return "https://stackoverflow.com/users/10303676/hangmanscustomer";
        }
    },
    HOME_PAGE("Домашняя страница:") {
        @Override
        public String getContactInfo() {
            return null;
        }
    };

    private String value;

    Contacts(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract String getContactInfo();

}
