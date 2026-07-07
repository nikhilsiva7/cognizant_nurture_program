--scenario 1: Update interest rates for customers over 60 years old
    DECLARE
    v_age NUMBER;
BEGIN
    FOR customer_rec IN (SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate 
                         FROM Customers c 
                         JOIN Loans l ON c.CustomerID = l.CustomerID) 
    LOOP
        
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, customer_rec.DOB) / 12);
        
       
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = customer_rec.LoanID;
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Interest rates updated for customers over 60.');
END;
/

--scenario 2 

ALTER TABLE Customers ADD IsVIP VARCHAR2(5) DEFAULT 'FALSE';


BEGIN
    FOR customer_rec IN (SELECT CustomerID, Balance FROM Customers) 
    LOOP
        IF customer_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer_rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status updated for customers with balance over $10,000.');
END;
/

--scenario 3: Send reminders for upcoming loan due dates    
BEGIN
    FOR loan_rec IN (SELECT c.Name, l.LoanID, l.EndDate 
                     FROM Loans l
                     JOIN Customers c ON l.CustomerID = c.CustomerID
                     WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30) 
    LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || loan_rec.Name || 
                             ', your loan (ID: ' || loan_rec.LoanID || 
                             ') is due on ' || TO_CHAR(loan_rec.EndDate, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/