// Exception Handling

class InvalidCommandException extends Exception {
    public InvalidCommandException(String message) {
        super(message);
    }
}
//Inheritance
// Parent Class 
class AssistantFeature {
    public void activate() {
        System.out.println("Productivity Assistant Activated");
    }
}
//            Hierarchical Inheritance
// Child Classes 
   
// Voice Commands
class VoiceModule extends AssistantFeature {
    public void respondToVoice(String command) {
        try {
            if (command == null || command.isEmpty()) {
                //throw->found a problem,take this error
                throw new InvalidCommandException("Voice command not recognized!");
            }
            System.out.println("Executing Voice Command: " + command);
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Text Commands
class TextModule extends AssistantFeature {
    public void processText(String text) {
        try {
            if (text == null || text.isEmpty()) {
                throw new InvalidCommandException("Text input not recognized!");
            }
            System.out.println("Processing Text Command: " + text);
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Smart Home Control
class SmartHomeModule extends AssistantFeature {
    public void controlDevice(String device, String action) {
        if (device.equalsIgnoreCase("offline")) {
            System.out.println("Device is offline!");
        } else {
            System.out.println("Performing action '" + action + "' on device: " + device);
        }
    }
}

// Calendar Events
class CalendarModule extends AssistantFeature {
    public void addEvent(String event, String time) {
        if (time == null || time.isEmpty()) {
            System.out.println("Invalid date/time for event!");
        } else {
            System.out.println("Event  '" + event + "' added at " + time);
        }
    }
}

// Reminders
class ReminderModule extends AssistantFeature {
    public void setReminder(String reminder, String time) {
        if (reminder == null || reminder.isEmpty()) {
            System.out.println("Reminder cannot be empty!");
        } else {
            System.out.println("Reminder set: " + reminder + " at " + time);
        }
    }
}

// Communication (Messages / Calls)
class CommunicationModule extends AssistantFeature {
    public void sendMessage(String contact, String message) {
        if (contact == null || contact.isEmpty()) {
            System.out.println("Contact not found!");
        } else {
            System.out.println("Message sent to " + contact + ": " + message);
        }
    }
}

//  Encapsulation 
// User Session
class UserSession {
    private String userName;        // private variable
    private int inactivityMinutes;  // private variable

    // Constructor
    public UserSession(String name) { //perameteraize cons
        userName = name;
        inactivityMinutes = 0;
    }

    // Method to directly update inactivity time
    public void updateInactivity(int minutes) {
        inactivityMinutes = minutes;
    }

    // Method to check timeout
    public void checkSessionTimeout() {
        if (inactivityMinutes > 5) {
            System.out.println("Session timed out! Please log in again.");
        } else {
            System.out.println("Session active for: " + userName);
        }
    }
}


// Main Function
public class ProductivityAssistantApp {

    public static void main(String[] args) throws Exception {
        // Start Assistant
        AssistantFeature assistant = new AssistantFeature();
        assistant.activate();

        // Encapsulation // User Session
        UserSession session = new UserSession("Amina");
        session.updateInactivity(6);  // Example
        session.checkSessionTimeout();

        // Voice Command
        VoiceModule voice = new VoiceModule();
        voice.respondToVoice("Play music");

        // Text Command
        TextModule text = new TextModule();
        text.processText("Set alarm at 6 AM");

        // Smart Home Device
        SmartHomeModule smart = new SmartHomeModule();
        smart.controlDevice("Light", "Turn Off");

        // Calendar Event
        CalendarModule calendar = new CalendarModule();
        calendar.addEvent("Team Meeting", "10:00 AM");

        // Reminder
        ReminderModule reminder = new ReminderModule();
        reminder.setReminder("Buy groceries", "5:00 PM");

        // Communication
        CommunicationModule comm = new CommunicationModule();
        comm.sendMessage("Ali", "I’ll be late today!");

        System.out.println(" All tasks executed successfully.");
    }
}

    
                                                                               
