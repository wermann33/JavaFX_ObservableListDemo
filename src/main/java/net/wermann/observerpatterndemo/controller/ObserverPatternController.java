package net.wermann.observerpatterndemo.controller;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import net.wermann.observerpatterndemo.models.PersonModel;
import net.wermann.observerpatterndemo.viewmodels.PersonListViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class ObserverPatternController implements Initializable {
    @FXML
    private ListView<PersonModel> personListView;
    @FXML
    private TextField nameTextField;

    private PersonListViewModel viewModel;

    public ObserverPatternController() {
        this.viewModel = new PersonListViewModel();
    }

    @FXML
    private void addPerson() {
        String name = nameTextField.getText(); // Holen Sie den eingegebenen Namen aus dem TextField
        if (!name.isEmpty()) {
            PersonModel person = new PersonModel();
            person.setName(name);
            viewModel.addPerson(person);
            nameTextField.clear(); // Clear the TextField after adding the person
        }
    }

    @FXML
    private void removePerson() {
//        PersonModel selectedPerson = personListView.getSelectionModel().getSelectedItem();
//        if (selectedPerson != null) {
//            viewModel.removePerson(selectedPerson);
//        }
        ObservableList<PersonModel> selectedItems = personListView.getSelectionModel().getSelectedItems();
        viewModel.getPersons().removeAll(selectedItems);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personListView.setItems(viewModel.getPersons());
        personListView.setCellFactory(param -> new ListCell<PersonModel>() {
            @Override
            protected void updateItem(PersonModel person, boolean empty) {
                super.updateItem(person, empty);
                if (empty || person == null || person.getName() == null) {
                    setText(null);
                } else {
                    setText(person.getName());
                }
            }
        });
        // Mehrfachauswahl aktivieren
        personListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        // Listener hinzufügen, um Änderungen an der ObservableList zu überwachen
        viewModel.addListener((ListChangeListener.Change<? extends PersonModel> change) -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    for (PersonModel person : change.getAddedSubList()) {
                        System.out.println("Person hinzugefügt: " + person.getName());
                    }
                }
                if (change.wasRemoved()) {
                    for (PersonModel person : change.getRemoved()) {
                        System.out.println("Person entfernt: " + person.getName());
                    }
                }
            }
        });
    }
}
