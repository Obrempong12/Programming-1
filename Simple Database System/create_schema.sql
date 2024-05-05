-- Create Books table
CREATE TABLE Books (
    ISBN VARCHAR(20) PRIMARY KEY,
    Title VARCHAR(100),
    Author VARCHAR(100),
    Genre VARCHAR(50),
    Quantity INT
);

-- Create Members table
CREATE TABLE Members (
    MemberID INT PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100),
    Phone VARCHAR(20)
);

-- Create Loans table
CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    MemberID INT,
    ISBN VARCHAR(20),
    LoanDate DATE,
    ReturnDate DATE,
    FOREIGN KEY (MemberID) REFERENCES Members(MemberID),
    FOREIGN KEY (ISBN) REFERENCES Books(ISBN)
);