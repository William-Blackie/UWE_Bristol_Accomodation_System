# UWE_Bristol_Accomodation_System
A project using JavaFX to create a functional UI for the administration of students in a hall of residence as well as intergrated user permissions

## Getting Started

Clone the repository.

### Prerequisites

As the project is using JavaFX, JDK 8.0+ needed to compile.

### Usage

Run MainApp.java which will present you with the following UI:

![UI_image.jpg](docs/img/UI_image.jpg?raw=true "Title")

New halls of residence can be selected from the combo box at the top left of the UI, by defeault Student village accomodation is loaded.
To populate the labels select one of the students in the list view which will display their hall info as well as other info such as room and lease.

![new_hall.jpg](docs/img/new_hall.jpg?raw=true "Title")

While a student is selected int the table view then you can select the edit button next to various features of students and their accomodaftion, this will create a popup containing the information for a studnet, this for examplke is the room edit dialog.

![room_edit.png](docs/img/room_edit.png?raw=true "Title")

For this project I added some user validation in the use of passwords for users, for example if a user such as a hallmanager tries to edit a feature they do not have permission to edit they will cause the following error message.

![password_invalid.jpg](docs/img/password_invalid.jpg?raw=true "Title")

There are in total 4 users, one hall manager and three hall wardens, the hall manager(password: ps1) has complete controll and can edit any student feature, however the hall wardens only may edit the the cleaning stastus of the room a student occupies.
HallManager passwords:
Student Village: password1
Carrol Court: password2
Wallscourt Park: password3

## Authors

* **William Blackie**

### License
[MIT](LICENSE)
