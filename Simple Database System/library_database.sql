-- This script creates a simple library management system database.

-- Create Books table to store book information
CREATE TABLE Books (
    ISBN VARCHAR(20) PRIMARY KEY,
    Title VARCHAR(100),
    Author VARCHAR(100),
    Genre VARCHAR(50),
    Quantity INT
);

-- Create Members table to store member information
CREATE TABLE Members (
    MemberID INT PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100),
    Phone VARCHAR(20)
);

-- Create Loans table to store loan information
CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    MemberID INT,
    ISBN VARCHAR(20),
    LoanDate DATE,
    ReturnDate DATE,
    FOREIGN KEY (MemberID) REFERENCES Members(MemberID),
    FOREIGN KEY (ISBN) REFERENCES Books(ISBN)
);

-- Insert sample records into Books, Members, and Loans tables
INSERT INTO Books (ISBN, Title, Author, Genre, Quantity) VALUES
('ISBN001', 'Book Title 1', 'Author 1', 'Fiction', 5),
('ISBN002', 'Book Title 2', 'Author 2', 'Non-Fiction', 3);

INSERT INTO Members (MemberID, Name, Email, Phone) VALUES
(1, 'John Doe', 'john@example.com', '123-456-7890'),
(2, 'Jane Smith', 'jane@example.com', '987-654-3210');

INSERT INTO Loans (LoanID, MemberID, ISBN, LoanDate, ReturnDate) VALUES
(1, 1, 'ISBN001', '2024-05-01', '2024-05-15'),
(2, 2, 'ISBN002', '2024-05-02', NULL);

-- Sample queries to demonstrate database operations:

-- Retrieve all books borrowed by a specific member
SELECT Books.*
FROM Books
JOIN Loans ON Books.ISBN = Loans.ISBN
WHERE Loans.MemberID = 1;

-- Update the quantity of a particular book
UPDATE Books
SET Quantity = 10
WHERE ISBN = 'ISBN001';

-- Delete a member record
DELETE FROM Members
WHERE MemberID = 2;