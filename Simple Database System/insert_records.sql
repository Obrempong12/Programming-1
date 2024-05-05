-- Insert into Books table
INSERT INTO Books (ISBN, Title, Author, Genre, Quantity) VALUES
('ISBN001', 'Book Title 1', 'Author 1', 'Fiction', 5),
('ISBN002', 'Book Title 2', 'Author 2', 'Non-Fiction', 3);

-- Insert into Members table
INSERT INTO Members (MemberID, Name, Email, Phone) VALUES
(1, 'John Doe', 'john@example.com', '123-456-7890'),
(2, 'Jane Smith', 'jane@example.com', '987-654-3210');

-- Insert into Loans table
INSERT INTO Loans (LoanID, MemberID, ISBN, LoanDate, ReturnDate) VALUES
(1, 1, 'ISBN001', '2024-05-01', '2024-05-15'),
(2, 2, 'ISBN002', '2024-05-02', NULL);