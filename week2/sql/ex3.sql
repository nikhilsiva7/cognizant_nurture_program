--scenario 1: process monthly interest for savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    -- Update all accounts where AccountType is 'Savings'
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all Savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred while processing monthly interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/

--scenario 2:  update employee bonus based on department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    -- Update the salary by adding the calculated bonus
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_bonus_percentage / 100))
    WHERE Department = p_department;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_percentage || '% applied to department: ' || p_department);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred while updating employee bonuses: ' || SQLERRM);
END UpdateEmployeeBonus;
/

--scenario 3:  update employee bonus based on department
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_source_balance NUMBER;
BEGIN
    -- Check the balance of the source account
    SELECT Balance INTO v_source_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id;
    
    -- Ensure sufficient balance exists
    IF v_source_balance >= p_amount THEN
        -- Deduct from source account
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_account_id;
        
        -- Add to destination account
        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_account_id;
        
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from Account ' || p_from_account_id || ' to Account ' || p_to_account_id);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance in source account (Account ' || p_from_account_id || ').');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: One or both Account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An unexpected error occurred during transfer: ' || SQLERRM);
END TransferFunds;
/