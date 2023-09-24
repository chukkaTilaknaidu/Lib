<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Librarian's View</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        /* Add alternating row colors (white and blue) */
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        /* Add button styles */
        .btn {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            margin-right: 10px;
        }

        /* Message styling */
        #message {
            background-color: #4CAF50;
            color: #fff;
            text-align: center;
            padding: 10px;
            margin-top: 10px;
        }

        .btn-disabled {
            background-color: #ccc;
            cursor: not-allowed;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Librarian's View</h1>
    <h2>Registration Number and Book ISBN Table</h2>
    <!-- Add a message div to display the messages -->
    <div id="message"></div>
    <table>
        <thead>
        <tr>
            <th>Student Registration Number</th>
            <th>Book ISBN</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <!-- Loop through all rows and generate a row for each one -->
        <c:forEach var="data" items="${requestScope.registrationNumber}">
            <tr id="row-${data}">
                <td>${data}</td>
                <td>${requestScope.bookISBN}</td>
                <td>
                    <button class="btn" data-action="accept" data-reg-number="${data}" id="accept-${data}">Request Accepted</button>
                    <button class="btn" data-action="deny" data-reg-number="${data}">Request Denied</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- JavaScript functions for button actions -->
<script>
    // Initialize an object to store messages for each row
    var rowMessages = {};

    // Attach click event listeners to the "Request Accepted" buttons
    <c:forEach var="data" items="${requestScope.registrationNumber}">
        var acceptButton${data} = document.getElementById("accept-${data}");
        acceptButton${data}.addEventListener("click", function () {
            var registrationNumber = acceptButton${data}.getAttribute("data-reg-number");
            handleRequest("accept", registrationNumber);
        });
    </c:forEach>

    // Attach click event listeners to the "Request Denied" buttons
    var denyButtons = document.querySelectorAll('[data-action="deny"]');
    denyButtons.forEach(function (button) {
        button.addEventListener("click", function () {
            var registrationNumber = button.getAttribute("data-reg-number");
            handleRequest("deny", registrationNumber);
        });
    });

    function handleRequest(action, registrationNumber) {
        var messageDiv = document.getElementById("message");
        var tableRow = document.getElementById("row-" + registrationNumber);

        if (action === "accept") {
            // Update the message content for "Request Accepted"
            rowMessages[registrationNumber] = "Request Accepted for Registration Number: " + registrationNumber;
            messageDiv.innerHTML = Object.values(rowMessages).join("<br>"); // Display all messages with line breaks

            // Disable the "Request Accepted" button to prevent multiple clicks
            document.getElementById("accept-" + registrationNumber).classList.add("btn-disabled");

            // Make an AJAX request to the Delete_Requests servlet to trigger the deletion
            var deleteRequestXhr = new XMLHttpRequest();
            deleteRequestXhr.open("POST", "Delete_Requests", true);
            deleteRequestXhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            deleteRequestXhr.onreadystatechange = function () {
                if (deleteRequestXhr.readyState === 4) {
                    if (deleteRequestXhr.status === 200) {
                        // Handle the response from Delete_Requests servlet if needed
                        console.log(deleteRequestXhr.responseText);

                        // After successful deletion, make another AJAX request to Borrowing_Students servlet
                        var borrowingStudentsXhr = new XMLHttpRequest();
                        borrowingStudentsXhr.open("POST", "Borrowing_Students", true);
                        borrowingStudentsXhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                        borrowingStudentsXhr.onreadystatechange = function () {
                            if (borrowingStudentsXhr.readyState === 4) {
                                if (borrowingStudentsXhr.status === 200) {
                                    // Handle the response from Borrowing_Students servlet if needed
                                    console.log(borrowingStudentsXhr.responseText);
                                } else {
                                    // Handle errors or display an error message for Borrowing_Students servlet
                                    console.error("Error occurred: " + borrowingStudentsXhr.status);
                                    // You can show an error message to the user
                                }
                            }
                        };
                        borrowingStudentsXhr.send("registrationNumber=" + registrationNumber);
                    } else {
                        // Handle errors or display an error message for Delete_Requests servlet
                        console.error("Error occurred: " + deleteRequestXhr.status);
                        // You can show an error message to the user
                    }
                }
            };
            deleteRequestXhr.send("action=accept&registrationNumber=" + registrationNumber);
        } else if (action === "deny") {
            // Print "Request Denied" message with red background and white text
            rowMessages[registrationNumber] = "Request Denied for Registration Number: " + registrationNumber;
            messageDiv.innerHTML = Object.values(rowMessages).join("<br>"); // Display all messages with line breaks
            messageDiv.style.backgroundColor = "red"; // Set background color to red for denial
            messageDiv.style.color = "white"; // Set text color to white for denial
        }
    }

</script>
</body>
</html>
