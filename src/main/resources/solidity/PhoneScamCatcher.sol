// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.0;

/// @title Phone Number Reporting System
contract PhoneNumberReport {

    struct User {
        string name;
        bytes userPhone;
    }

    struct PhoneReport {
        uint count; // number of times reported
        bool reported; // if true, the number has been reported
        uint firstReportTime; // timestamp of the first report
    }

    // Mapping from user address to their details
    mapping(address => User) public users;

    // Mapping from phone number to its report details.
    mapping(bytes => PhoneReport) public reports;

    // Register a user with their name and phone number
    function registerUser(string memory name, bytes memory phone) public {
        require(users[msg.sender].userPhone.length == 0, "User already registered.");
        users[msg.sender] = User({name: name, userPhone: phone});
    }

    /// Report a phone number.
    function reportNumber(bytes memory phoneNumber) public {
        require(users[msg.sender].userPhone.length > 0, "Register first.");

        // If the number hasn't been reported yet, initialize it.
        if(!reports[phoneNumber].reported) {
            reports[phoneNumber] = PhoneReport({
                count: 1,
                reported: true,
                firstReportTime: block.timestamp
            });
        } else {
            // If it has been reported, just increment the count.
            reports[phoneNumber].count += 1;
        }
    }

    /// Check how many times a phone number has been reported in the last `timePeriod` seconds.
    function checkReports(bytes memory phoneNumber, uint timePeriod) public view returns (uint) {
        PhoneReport memory report = reports[phoneNumber];
        if(block.timestamp <= report.firstReportTime + timePeriod) {
            return report.count;
        } else {
            return 0;
        }
    }
}
