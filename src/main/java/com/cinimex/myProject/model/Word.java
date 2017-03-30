package com.cinimex.myProject.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String original;
    private String translated;
    private Integer priority;

    public Word() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", original='" + original + '\'' +
                ", translated='" + translated + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (id != null ? !id.equals(word.id) : word.id != null) return false;
        if (original != null ? !original.equals(word.original) : word.original != null) return false;
        if (translated != null ? !translated.equals(word.translated) : word.translated != null) return false;
        return priority != null ? priority.equals(word.priority) : word.priority == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (original != null ? original.hashCode() : 0);
        result = 31 * result + (translated != null ? translated.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }
}
