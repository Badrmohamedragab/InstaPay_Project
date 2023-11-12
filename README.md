# InstaPay Project

Welcome to the InstaPay Project! This application is designed to provide users with a convenient and secure platform for financial transactions, including transfers, bill payments, and account management.

## Table of Contents

1. [Requirements](#requirements)
    - [User Registration](#user-registration)
    - [User Authentication](#user-authentication)
    - [User Actions](#user-actions)
2. [Packages](#packages)

## Requirements

### User Registration

1. Users can sign up in two ways:
   - Register using their bank account and the registered mobile number on the bank so the app can verify it through the bank API.
   - Register using their mobile number with a wallet provided from a wallet provider. Mobile numbers should be verified with the wallet provider.

2. After verifying the bank account/wallet, the system should verify that the user owns the mobile number by sending OTP and then verifying it. Users must then enter a unique username and a complex password.

### User Authentication

1. Users can sign in using their InstaPay username and password.
2. Upon logging in, the user's profile is loaded based on their account type.

### User Actions

1. Both users (Bank account and Wallet users) have the following options:
   - **Transfer to Wallet:** Users can transfer funds to another user's wallet using their mobile number.
   - **Transfer to Another InstaPay Account:** Users can transfer funds to another InstaPay account.
   - **Inquire about Balance:** Users can check their account balance.
   - **Pay Bills:** Users can pay utility bills, including Gas, Electricity, and Water.

2. Transferring to a bank account is only valid for users registered using their bank account.

## Packages

1. **User:** Manages user registration and profile information.
2. **User Authentication:** Handles user login and authentication.
3. **Provider:** Manages wallet providers and bank API interactions.
4. **APIs:** Contains interfaces and methods for external API interactions.
5. **DataBase:** Deals with database operations and user data storage.
6. **Bills:** Manages the creation and payment of utility bills (Gas, Electricity, Water).
7. **Transfer:** Facilitates fund transfers between users and accounts.
8. **Account:** Handles account-related functionalities.

