package what.gui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Dialog that lets you enter a page number to jump to.
 * 
 * @author Gwindow
 * @since May 25, 2012 1:43:13 PM
 */
public abstract class JumpToPageDialog extends AlertDialog.Builder implements OnClickListener, JumpToPageInterface {

	/** The Constant DIALOG_TITLE. */
	private static final String DIALOG_TITLE = "Jump to Page";

	/** The Constant PAGE_FIELD_HINT. */
	private static final String PAGE_FIELD_HINT = "Page...";

	/** The Constant ERROR_MESSAGE. */
	private static final String ERROR_MESSAGE = "Not a valid page";

	/** The max page. */
	private int maxPage;

	/** The page field. */
	private EditText pageField;

	/** The page, default is -1 */
	private int page = -1;

	/**
	 * Instantiates a new jump to page dialog.
	 * 
	 * @param context
	 *            the context
	 * @param maxPage
	 *            the max number of pages
	 */
	public JumpToPageDialog(Context context, Number maxPage) {
		super(context);
		if (maxPage != null) {
			this.maxPage = maxPage.intValue();
			setTitle(DIALOG_TITLE);
			setCancelable(true);
			setNegativeButton("Entered Page", this);
			setNeutralButton("First Page", this);
			setPositiveButton("Last Page", this);
			pageField = new EditText(context);
			pageField.setInputType(InputType.TYPE_CLASS_NUMBER);
			pageField.setHint(PAGE_FIELD_HINT);
			setView(pageField);
		} else {
			Toast.makeText(getContext(), "No pages", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		if (which == AlertDialog.BUTTON_NEGATIVE) {
			try {
				int input = Integer.valueOf(pageField.getText().toString());
				if (input > 0 && input <= maxPage) {
					page = input;
					jumpToPage();
				} else {
					Toast.makeText(getContext(), ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
				}
			} catch (Exception e) {
				Toast.makeText(getContext(), ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
			}
		}
		if (which == AlertDialog.BUTTON_NEUTRAL) {
			page = 1;
			jumpToPage();
		}

		if (which == AlertDialog.BUTTON_POSITIVE) {
			page = maxPage;
			jumpToPage();
		}
	}

	/**
	 * Gets the page.
	 * 
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

}
