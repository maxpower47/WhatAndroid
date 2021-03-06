package what.gui;

/**
 * @author Gwindow
 * @since May 25, 2012 9:15:15 AM
 */
public enum ActivityNames {
	HOME("Home"), FORUM("Forum"), SEARCH("Search"), INBOX("Inbox"), MUSIC("Music"), USER("User"), NOTIFICATIONS("Notifications"),
	SCANNER("Scanner"), BOOKMARKS("Bookmarks"), TOPTEN("Top 10"), REQUEST("Request"), STATUS("Status"), DEBUG("Debug");

	private final String name;

	private ActivityNames(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
