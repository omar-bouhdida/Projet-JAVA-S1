package com.library;

import com.library.model.Book;
import com.library.model.Member;
import com.library.model.Loan;
import com.library.service.BookService;
import com.library.service.MemberService;
import com.library.service.LoanService;

import java.util.Scanner;

public class LibraryManagementSystemTest {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        MemberService memberService = new MemberService();
        LoanService loanService = new LoanService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Create Loan");
            System.out.println("4. View All Books");
            System.out.println("5. View All Members");
            System.out.println("6. View All Loans");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Book
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    Book book = new Book(null, title, author, isbn);
                    bookService.save(book);
                    System.out.println("Book added successfully!");
                    break;

                case 2: // Add Member
                    System.out.print("Enter member name: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Enter member email: ");
                    String memberEmail = scanner.nextLine();
                    Member member = new Member(null, memberName, memberEmail);
                    memberService.save(member);
                    System.out.println("Member added successfully!");
                    break;

                case 3: // Create Loan
                    System.out.print("Enter member ID: ");
                    int memberId = scanner.nextInt();
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    System.out.print("Enter loan date (yyyy-mm-dd): ");
                    String loanDateInput = scanner.next();
                    java.util.Date loanDate = java.sql.Date.valueOf(loanDateInput); // Ensure the format is correct
                    Loan loan = new Loan(null, (long) memberId, (long) bookId, loanDate);
                    loanService.save(loan);
                    System.out.println("Loan created successfully!");
                    break;

                case 4: // View All Books
                    System.out.println("Books: " + bookService.getAllBooks());
                    break;

                case 5: // View All Members
                    System.out.println("Members: " + memberService.getAllMembers());
                    break;

                case 6: // View All Loans
                    System.out.println("Loans: " + loanService.getAllLoans());
                    break;

                case 7: // Exit
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
