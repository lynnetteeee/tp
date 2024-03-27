package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.Messages;
import seedu.address.model.person.Person;
import seedu.address.model.Model;

import java.util.logging.Logger;

import static java.util.Objects.requireNonNull;

/**
 * Performs the actual deletion of contact after user has been prompted for confirmation.
 */
public class RemoveSuccess extends RemoveConfirmation {

    public static final String COMMAND_WORD = "yes";

    public static final String MESSAGE_REMOVE_PERSON_SUCCESS = "Successfully Removed Contact: %1$s";

    private final int DEFAULT_INDEX = 0;

    public RemoveSuccess() {
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (!isValidConfirmation()) {
            throw new CommandException(MESSAGE_INVALID_DECISION_MAKING);
        }
        Person personToRemove = model.getFilteredPersonList().get(DEFAULT_INDEX);
        model.deletePerson(personToRemove);
        return new CommandResult(successMessage(personToRemove));
    }

    /**
     * Returns the success message for the removal of the contact.
     * @param personToRemove Contact to be removed.
     * @return Success message for the removal of the contact.
     */
    public String successMessage(Person personToRemove) {
        return String.format(MESSAGE_REMOVE_PERSON_SUCCESS, Messages.format(personToRemove));
    }
}
