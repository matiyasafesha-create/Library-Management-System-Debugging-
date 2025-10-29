package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private String email;
    private List<String> borrowedBooks;

    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<String> getBorrowedBooks() { return new ArrayList<>(borrowedBooks); }

    // Book management
//    public boolean borrowBook(String isbn) {
//        borrowedBooks.add(isbn);
//        return true;
//    }

    // book management/////                          Ticket #2: Member Can Borrow Same Book Multiple Times

    public boolean borrowBook(String isbn){
        if(borrowedBooks.contains(isbn)){
            return false;
        }
        borrowedBooks.add(isbn);
        return true;
    }




    public boolean returnBook(String isbn) {
        return borrowedBooks.remove(isbn);
    }

    public boolean hasBorrowedBook(String isbn) {
        return borrowedBooks.contains(isbn);
    }
//
//    public boolean hasBorrowedBook(Book book){
//
//        String isbn = book.getIsbn();
//
//        if(borrowedBooks.remove(isbn)){
//            book.setAvailable(true);
//            return true;
//        }
//
//        return false;
//
//    }



    public int getBorrowedCount() {
        return borrowedBooks.size();
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%s) - %d books borrowed",
                memberId, name, email, borrowedBooks.size());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Member member = (Member) obj;
        return memberId.equals(member.memberId);
    }

    @Override
    public int hashCode() {
        return memberId.hashCode();
    }
}