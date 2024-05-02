package net.wermann.observerpatterndemo.viewmodels;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import net.wermann.observerpatterndemo.models.PersonModel;

public class PersonListViewModel {
    private ObservableList<PersonModel> persons = FXCollections.observableArrayList();

    public ObservableList<PersonModel> getPersons() {
        return persons;
    }

    public void addPerson(PersonModel person) {
        persons.add(person);
    }

    public void removePerson(PersonModel person) {
        persons.remove(person);
    }

    public void addListener(ListChangeListener<? super PersonModel> listener) {
        persons.addListener(listener);
    }

    public void removeListener(ListChangeListener<? super PersonModel> listener) {
        persons.removeListener(listener);
    }
}
