SELECT Books.*
FROM Books
JOIN Loans ON Books.ISBN = Loans.ISBN
WHERE Loans.MemberID = 1;