# Mortgage Calculator (Java)

This is a **Java** project that calculates:

* Monthly mortgage payments
* Full payment schedule (remaining balance month by month)
* Input validation with ranges
* Clean output formatting with titles and currency values

## Features

* Mortgage calculation using the standard amortization formula
* Remaining balance calculation after each payment
* Automatic currency formatting (`NumberFormat`)
* `readNumber` function with min/max validation
* Clean console output with dynamic title formatting

## Formulas Used

### **Monthly Payment (Mortgage):**

```
M = P * [ r(1+r)^n / ((1+r)^n - 1) ]
```

Where:

* `P` = Principal
* `r` = Monthly interest rate
* `n` = Total number of payments

### **Remaining Balance After Each Payment:**

```
B = P * [ (1+r)^n - (1+r)^p ] / [ (1+r)^n - 1 ]
```

Where `p` is the number of payments already made.

## Project Structure

```
src/
 └── Main.java
```

## How to Run

Compile the program:

```
javac Main.java
```

Run it:

```
java Main
```

Enter:

* Principal
* Annual Interest Rate
* Period (Years)

The program will print:

* Monthly payment
* Full amortization schedule

## Example Output

```
MORTGAGE
________
Monthly Payments: $1,432.25

PAYMENT SCHEDULE
________________
$299,567.84
$298,912.52
$298,255.21
...
```

## Project Goal

This project was created as an exercise to practice:

* Financial math in Java
* Input validation
* Clean and reusable methods
* Console formatting
