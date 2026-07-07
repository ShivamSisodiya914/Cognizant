SET SERVEROUTPUT ON;

/*
Assumptions:
- savings_accounts table with columns:
  account_id, balance, interest_rate
- employees table with columns:
  employee_id, department_id, salary
- accounts table with columns:
  account_id, balance
*/

-- Scenario 1: Process monthly interest for all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  UPDATE savings_accounts
  SET balance = balance + (balance * 0.01);

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');
END;
/

-- Scenario 2: Update employee bonus based on department and bonus percentage
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_department_id IN NUMBER,
  p_bonus_percent IN NUMBER
) AS
BEGIN
  UPDATE employees
  SET salary = salary + (salary * (p_bonus_percent / 100))
  WHERE department_id = p_department_id;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Employee bonuses updated successfully.');
END;
/

-- Scenario 3: Transfer funds between two accounts if sufficient balance exists
CREATE OR REPLACE PROCEDURE TransferFunds (
  p_from_account_id IN NUMBER,
  p_to_account_id IN NUMBER,
  p_amount IN NUMBER
) AS
  v_from_balance NUMBER;
BEGIN
  SELECT balance
  INTO v_from_balance
  FROM accounts
  WHERE account_id = p_from_account_id;

  IF v_from_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for transfer.');
  END IF;

  UPDATE accounts
  SET balance = balance - p_amount
  WHERE account_id = p_from_account_id;

  UPDATE accounts
  SET balance = balance + p_amount
  WHERE account_id = p_to_account_id;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transfer completed successfully.');
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RAISE_APPLICATION_ERROR(-20002, 'One or both accounts do not exist.');
END;
/
