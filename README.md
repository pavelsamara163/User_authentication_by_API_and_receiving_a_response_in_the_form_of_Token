# User_authentication_by_API_and_receiving_a_response_in_the_form_of_Token

The application is developed on AndroidStudio 2.2.2.
The development of the project is to create an authorization system. The user fills in the login and password and presses the button.
The completed user data is collected in the packet and sent to the server (User data is encrypted in SHA-256 format),
The server in turn checks the data and if they match, it sends TOKEN back to the application, our application if it receives Token
That sends the user to the previous screen, if not, then toggles it to the initial screen with an error.
