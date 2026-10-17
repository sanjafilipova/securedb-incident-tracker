import java.util.Scanner;
import java.util.ArrayList;

// SecureDB Incident Tracker
// This program helps a user keep database security incidents organized.
// The user can add, view, search, update, and save incident information.
public class Main {
    
    // Keeps all of the security incidents together while the program is open.
    static ArrayList<Incident> incidents = new ArrayList<Incident>();
    
    // Reads information entered by the user.
    static Scanner scanner = new Scanner(System.in);
    
    // Keeps track of the next available incident ID.
    // The first incident starts with ID 1001.
    static int nextIncidentId = 1001;
    
    // Starts the program by loading saved incidents and then showing the main menu.
    public static void main(String[] args) {
        
        // Loads any incidents that were saved during a previous use of the program.
        loadIncidents();
        
        // Stores the menu option selected by the user.
        int choice = 0;
        
        // Continues displaying the menu until the user selects option 6 to exit.
        while (choice != 6) {
            System.out.println();
            System.out.println("==================================");
            System.out.println("    SecureDB Incident Tracker");
            System.out.println("==================================");
            System.out.println("1. Add New Incident");
            System.out.println("2. View All Incidents");
            System.out.println("3. Search Incident by ID");
            System.out.println("4. Update Incident Status");
            System.out.println("5. View High/Critical Incidents");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");

            // Checks that the user entered a number before reading the menu choice.
            // If the user enters something other than a number, the program displays an error message and returns to the main menu.
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();}
            else {
                System.out.println("Invalid menu choice. Please enter a number from 1 to 6.");
                scanner.nextLine();
                continue;}
            
            // Runs the part of the program that matches the option selected by the user.
            if (choice == 1) {
                addIncident();}
            else if (choice == 2) {
                viewIncidents();}
            else if (choice == 3) {
                searchIncident();}
            else if (choice == 4) {
                updateIncidentStatus();}
            else if (choice == 5) {
                viewHighCriticalIncidents();}
            else if (choice == 6) {
                
                // Saves the incidents one last time before the program closes.
                saveIncidents();
                System.out.println();
                System.out.println("==================================");
                System.out.println("    SecureDB Incident Tracker");
                System.out.println("            Closed");
                System.out.println("==================================");
            }
            else {
                System.out.println("Invalid menu choice. Please enter a number from 1 to 6.");}
        }
    }
    
    // Collects information from the user, creates a new incident, and saves it.
    public static void addIncident() {
        
        // Clears the leftover input from the menu choice before reading text responses.
        scanner.nextLine();
        System.out.println();
        
        // Asks the user for the information needed to describe the new incident.
        System.out.print("Enter incident type: ");
        String type = scanner.nextLine();
        
        System.out.print("Enter affected database or system: ");
        String affectedSystem = scanner.nextLine();
        
        System.out.print("Enter severity level: ");
        String severity = scanner.nextLine();
        
        System.out.print("Enter current status: ");
        String status = scanner.nextLine();
        
        // Creates a new incident using the next available ID and the information entered.
        Incident newIncident = new Incident(
            nextIncidentId,
            type,
            affectedSystem,
            severity,
            status);
        
        // Adds the new incident to the collection of incidents.     
        incidents.add(newIncident);
        
        // Saves the updated incident information to the external text file.
        saveIncidents();
        
        // Confirms that the incident was successfully added.
        System.out.println();
        System.out.println("Incident " + nextIncidentId + " was successfully added.");
        
        // Increases the ID number so the next incident receives a different ID.
        nextIncidentId++;
    }
    
    // Displays all saved security incidents.
    public static void viewIncidents() {
        
        // Checks whether there are any incidents available to display.
        if (incidents.isEmpty()) {
            System.out.println();
            System.out.println("No incidents are available.");}
        else {
            System.out.println();
            System.out.println("----------------------------------");
            System.out.println("      All Security Incidents");
            System.out.println("----------------------------------");
            System.out.println();
            
            // Goes through the incident list and displays the information for each incident.
            for (Incident incident : incidents) {
                System.out.println("Incident ID: " + incident.getId());
                System.out.println("Type: " + incident.getType());
                System.out.println("Affected System: " + incident.getAffectedSystem());
                System.out.println("Severity: " + incident.getSeverity());
                System.out.println("Status: " + incident.getStatus());
                System.out.println("----------------------------------");
            }
        }
        
    }
    
    // Lets the user enter an incident ID and looks for the incident with that number.
    public static void searchIncident() {
        
        // Gets the incident ID that the user wants to find.
        System.out.println();
        scanner.nextLine();
        
        int searchId;
        
        while (true) {
            System.out.print("Enter incident ID: ");
            String searchInput = scanner.nextLine();

            // Tries to read the user's entry as a number and asks again if it is not a valid number.
            try {
                searchId = Integer.parseInt(searchInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid incident ID. Please enter a number.");
            }
        }
        
        // Keeps track of whether a matching incident has been found.
        boolean found = false;
        
        // Checks each stored incident until a matching ID is found.
        for (Incident incident : incidents) {
            if (incident.getId() == searchId) {
                
                // Displays all information for the matching incident.
                System.out.println();
                System.out.println("----------------------------------");
                System.out.println("      Incident Search Result");
                System.out.println("----------------------------------");
                System.out.println();
                System.out.println("Incident ID: " + incident.getId());
                System.out.println("Type: " + incident.getType());
                System.out.println("Affected System: " + incident.getAffectedSystem());
                System.out.println("Severity: " + incident.getSeverity());
                System.out.println("Status: " + incident.getStatus());
                System.out.println("----------------------------------");
                
                // Records that a matching incident was found and stops the search.
                found = true;
                break;
            }
        }
        
        // Tells the user if no incident had the ID they entered.
        if (!found) {
            System.out.println();
            System.out.println("Incident ID " + searchId + " could not be found.");
        }
    }
    
    // Finds an incident by ID and allows the user to change its current status.
    public static void updateIncidentStatus() {
        
        // Gets the ID of the incident that the user wants to update.
        System.out.println();
        scanner.nextLine();
        
        int updateId;        
        
        while (true) {
            System.out.print("Enter incident ID: ");
            String updateInput = scanner.nextLine();
        
            // Tries to read the user's entry as a number and asks again if it is not a valid number.
            try {
                updateId = Integer.parseInt(updateInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid incident ID. Please enter a number.");
            }
        }
        
        // Keeps track of whether the requested incident has been found.
        boolean found = false;
        
        // Searches the incident list for the ID entered by the user.
        for (Incident incident : incidents) {
            if (incident.getId() == updateId) {
                
                // Asks the user what the new status should be.
                System.out.println();
                System.out.print("Enter new status: ");
                String newStatus = scanner.nextLine();
                
                // Updates the status and saves the changes to the external file.
                incident.setStatus(newStatus);
                saveIncidents();
                
                // Confirms that the status was successfully changed.
                System.out.println();
                System.out.println("Incident " + updateId + " status was successfully updated.");
                
                found = true;
                break;
            }
        }
        
        // Tells the user if an incident with the requested ID does not exist.
        if (!found) {
            System.out.println();
            System.out.println("Incident ID " + updateId + " could not be found.");
        }
    }
    
    // Displays only incidents that have a High or Critical severity level.
    public static void viewHighCriticalIncidents() {
        
        // Keeps track of whether at least one High or Critical incident is found.
        boolean found = false;
        
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("     High/Critical Incidents");
        System.out.println("----------------------------------");
        System.out.println();
        
        // Checks the severity level of each saved incident.
        for (Incident incident : incidents) {
            
            // Displays the incidents with High or Critical severity.
            if (incident.getSeverity().equalsIgnoreCase("High") ||
            incident.getSeverity().equalsIgnoreCase("Critical")) {
            
            System.out.println("Incident ID: " + incident.getId());
            System.out.println("Type: " + incident.getType());
            System.out.println("Affected System: " + incident.getAffectedSystem());
            System.out.println("Severity: " + incident.getSeverity());
            System.out.println("Status: " + incident.getStatus());
            System.out.println("----------------------------------");
            
            found = true;
            }
        }
        
        // Displays a message if there were no High or Critical incidents.
        if (!found) {
            System.out.println("No High or Critical incidents are available.");
        }
    }
    
    // Saves all incidents to an external text file so they can be used again later.
    public static void saveIncidents() {
        
        try {
            // Opens the incidents.txt file so the current incident information can be saved.
            java.io.PrintWriter writer = new java.io.PrintWriter("incidents.txt");
            
            // Writes each incident to the file using the | symbol to separate the fields.
            for (Incident incident : incidents) {
                writer.println(
                    incident.getId() + "|" +
                    incident.getType() + "|" +
                    incident.getAffectedSystem() + "|" +
                    incident.getSeverity() + "|" +
                    incident.getStatus()
                );
            }
            
            // Closes the file after all incident information has been saved.
            writer.close();
    
        // Displays an error message if the program is unable to save the file.
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Error saving incidents to file.");
        }
    }
    
    // Loads saved incidents from the text file when the program starts.
    public static void loadIncidents() {
        
        try {
            // Opens the file containing incidents that were saved during earlier use.
            java.io.File file = new java.io.File("incidents.txt");
            Scanner fileScanner = new Scanner(file);
            
            // Reads the saved incidents one line at a time until the end of the file.
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                
                // Separates the saved line into the five incident fields.
                String[] data = line.split("\\|");
                
                // Places each saved piece of information back into the correct category.
                int id = Integer.parseInt(data[0]);
                String type = data[1];
                String affectedSystem = data[2];
                String severity = data[3];
                String status = data[4];
                
                // Uses the saved information to rebuild the incident inside the program.
                Incident incident = new Incident(
                    id,
                    type,
                    affectedSystem,
                    severity,
                    status);
                    
                // Adds the rebuilt incident to the incidents available in the program.
                incidents.add(incident);
                
                // Makes sure the next incident will not reuse an existing ID.
                if (id >= nextIncidentId) {
                    nextIncidentId = id + 1;
                }
            }
            
            // Closes the saved incident file after all information has been loaded.
            fileScanner.close();
            
        } catch (java.io.FileNotFoundException e) {
            // If no saved file exists yet, the program starts with an empty list.
        }
    }
}
