package ru.javawebinar.basejava.model;

public enum TextSection {
    PERSONAL("-Личные качества") {
        @Override
        public String getTextInfo() {
            return "Перечисление личных качеств";
        }
    },
    OBJECTIVE("-Позиция") {
        @Override
        public String getTextInfo() {
            return "Описание позиции";
        }
    };

    private String title;

    TextSection(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getTextInfo() {
        return null;
    }
}
