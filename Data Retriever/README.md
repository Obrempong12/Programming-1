# Library Management System Database Assignment
---
This assignment focuses on creating and manipulating a database system for managing a library. It includes extending the existing database schema, populating tables with sample data, and writing SQL queries for various operations.

## Database Schema

The database schema consists of the following entities:

- Books (ISBN, Title, Author, Genre, Quantity)
- Members (MemberID, Name, Email, Phone)
- Loans (LoanID, MemberID, ISBN, LoanDate, ReturnDate)

For this assignment, an additional table is introduced:

- Authors (AuthorID, Name, Nationality, BirthYear)

## Assignment Tasks

### a. Extend the Existing Database Schema

A new table for Authors is created to store information about authors.

### b. Populate the Tables with Sample Data

Sample data is inserted into the Books, Authors, and Members tables.

### c. SQL Queries for Operations

1. **Retrieve all books written by a specific author**.
2. **Drop the newly created Authors table**.
3. **Identify the names of all members who have borrowed a specific book**.
4. **Alter the "Members" table to include a new attribute called "MembershipType"**.

## File Names and Contents

1. `create_authors_table.sql`: SQL script to create the Authors table.
2. `populate_sample_data.sql`: SQL script to populate the Books, Authors, and Members tables with sample data.
3. `queries_operations.sql`: SQL script containing queries for the specified operations.
4. `drop_authors_table.sql`: SQL script to drop the Authors table.
5. `find_members_borrowed_book.sql`: SQL script to identify members who have borrowed a specific book.
6. `alter_members_membership_type.sql`: SQL script to alter the Members table to include a new attribute called "MembershipType".

## Usage

1. Execute `create_authors_table.sql` to create the Authors table.
2. Execute `populate_sample_data.sql` to populate the tables with sample data.
3. Execute queries in `queries_operations.sql` to perform various operations.
4. If needed, use `drop_authors_table.sql` to drop the Authors table.
5. Use `find_members_borrowed_book.sql` to identify members who borrowed a specific book.
6. Use `alter_members_membership_type.sql` to add a new attribute "MembershipType" to the Members table.

## Notes

- Ensure proper database connectivity and permissions before executing the SQL scripts.
- Make necessary adjustments to the sample data and queries according to specific requirements.
---
## Contributors

- [Peter Kwesi Obrempong Stephenson][tuntumbrane@gmail.com]
# DO NOT EDIT
