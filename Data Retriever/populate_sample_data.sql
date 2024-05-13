-- Inserting sample data into Authors table
INSERT INTO Authors (AuthorID, Name, Nationality, BirthYear)
VALUES
    (1, 'Jane Austen', 'British', 1775),
    (2, 'George Orwell', 'British', 1903),
    (3, 'J.K. Rowling', 'British', 1965),
    (4, 'F. Scott Fitzgerald', 'American', 1896),
    (5, 'Harper Lee', 'American', 1926);

-- Inserting sample data into Books table
INSERT INTO Books (ISBN, Title, Author, Genre, Quantity)
VALUES
    ('9780141439518', 'Pride and Prejudice', 1, 'Romance', 5),
    ('9780451524935', '1984', 2, 'Dystopian', 3),
    ('9780743273565', 'To Kill a Mockingbird', 5, 'Fiction', 7),
    ('9780743273565', 'To Kill a Mockingbird', 5, 'Fiction', 7),
    ('9781408855652', 'Harry Potter and the Sorcerer''s Stone', 3, 'Fantasy', 10),
    ('9781408855652', 'Harry Potter and the Sorcerer''s Stone', 3, 'Fantasy', 10),
    ('9780743273565', 'The Great Gatsby', 4, 'Classic', 4),
    ('9780743273565', 'The Great Gatsby', 4, 'Classic', 4),
    ('9780743273565', 'The Great Gatsby', 4, 'Classic', 4),
    ('9780743273565', 'The Great Gatsby', 4, 'Classic', 4);

-- Inserting sample data into Members table
INSERT INTO Members (MemberID, Name, Email, Phone)
VALUES
    (1, 'John Doe', 'john@example.com', '1234567890'),
    (2, 'Jane Smith', 'jane@example.com', '0987654321'),
    (3, 'Alice Johnson', 'alice@example.com', '5551234567'),
    (4, 'Bob Brown', 'bob@example.com', '9876543210'),
    (5, 'Emma Davis', 'emma@example.com', '4567890123');
