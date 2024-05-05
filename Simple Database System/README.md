---
# Library Management System

This project implements a simple database system to manage a library. It includes functionalities to store information about books, members, and loans, along with SQL queries to perform various operations.

## Database Schema

The database schema includes three tables:

1. **Books**: Stores information about books including ISBN, title, author, genre, and quantity.
2. **Members**: Stores information about library members including MemberID, name, email, and phone number.
3. **Loans**: Tracks loans with attributes LoanID, MemberID, ISBN, loan date, and return date.

## SQL Scripts

The project includes several SQL scripts:

- **create_schema.sql**: Defines the database schema by creating the necessary tables.
- **insert_records.sql**: Inserts sample records into the Books, Members, and Loans tables.
- **retrieve_books_by_member.sql**: Retrieves all information about books borrowed by a specific member.
- **update_book_quantity.sql**: Updates the quantity of a particular book in the Books table.
- **delete_member_record.sql**: Deletes a member record from the Members table.
- **library_database.sql**: Combines schema creation, record insertion, and sample queries into a single script.

## Instructions

1. Install a Relational DBMS of your choice.
2. Execute the SQL scripts in the provided order to create the database schema, insert sample records, and perform operations.
3. Ensure to provide screenshots displaying all records in the mentioned relations as asked in the assignment.

## Contributors

- [Peter Kwesi Obrempong Stephenson][tuntumbrane@gmail.com]

## License

This project is licensed under the [License Name] License - see the [LICENSE](LICENSE) file for details.

---