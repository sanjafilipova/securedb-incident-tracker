// This class represents one database security incident.
// It keeps all of the information that belongs to one incident together.
public class Incident {
    
    // Stores the ID, type, affected system, severity, and status of the incident.
    private int id;
    private String type;
    private String affectedSystem;
    private String severity;
    private String status;
    
    // Creates an incident and stores all of the information provided for it.
    public Incident(int id, String type, String affectedSystem, String severity, String status) {
        this.id = id;
        this.type = type;
        this.affectedSystem = affectedSystem;
        this.severity = severity;
        this.status = status;
    }
    
    // Provides the incident ID when another part of the program needs it.
    public int getId() {
        return id;
    }
    
    // Provides the incident type when another part of the program needs it.
    public String getType() {
        return type;
    }
    
    
    // Provides the affected database or system when another part of the program needs it.
    public String getAffectedSystem() {
        return affectedSystem;
    }
    
    
    // Provides the severity level when another part of the program needs it.
    public String getSeverity() {
        return severity;
    }
    
    // Provides the current status when another part of the program needs it.
    public String getStatus() {
        return status;
    }
    
    
    // Allows the status of an existing incident to be changed.
    public void setStatus(String status) {
        this.status = status;
    }
}
