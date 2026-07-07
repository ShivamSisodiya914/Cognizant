SET SERVEROUTPUT ON;

/*
Assumption:
- The schema contains a customers table with columns:
  customer_id, age, balance, current_interest_rate, isvip
- The schema contains a loans table with columns:
  loan_id, customer_id, due_date
*/

-- Scenario 1: Apply 1% discount to interest rate for customers above 60
DECLARE
  CURSOR c_customers IS
    SELECT customer_id, age, current_interest_rate
    FROM customers
    FOR UPDATE;
BEGIN
  FOR rec IN c_customers LOOP
    IF rec.age > 60 THEN
      UPDATE customers
      SET current_interest_rate = rec.current_interest_rate * 0.99
      WHERE customer_id = rec.customer_id;

      DBMS_OUTPUT.PUT_LINE('Discount applied to customer ' || rec.customer_id);
    END IF;
  END LOOP;

  COMMIT;
END;
/

-- Scenario 2: Mark customers as VIP if their balance is over $10,000
DECLARE
  CURSOR c_customers IS
    SELECT customer_id, balance, isvip
    FROM customers
    FOR UPDATE;
BEGIN
  FOR rec IN c_customers LOOP
    IF rec.balance > 10000 THEN
      UPDATE customers
      SET isvip = 'Y'
      WHERE customer_id = rec.customer_id;
    ELSE
      UPDATE customers
      SET isvip = 'N'
      WHERE customer_id = rec.customer_id;
    END IF;
  END LOOP;

  COMMIT;
END;
/

-- Scenario 3: Print reminders for loans due in the next 30 days
DECLARE
  CURSOR c_loans IS
    SELECT l.loan_id,
           l.customer_id,
           c.customer_name,
           l.due_date
    FROM loans l
    JOIN customers c ON c.customer_id = l.customer_id
    WHERE l.due_date BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE) + 30;
BEGIN
  FOR rec IN c_loans LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: ' || rec.customer_name ||
      ' (Customer ID ' || rec.customer_id ||
      ') - Loan ' || rec.loan_id ||
      ' is due on ' || TO_CHAR(rec.due_date, 'DD-MON-YYYY')
    );
  END LOOP;
END;
/
