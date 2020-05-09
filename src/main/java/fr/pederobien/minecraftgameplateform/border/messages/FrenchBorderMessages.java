package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum FrenchBorderMessages {
	BORDER_EXPLANATION(Border_Explanation.FRENCH),

	NEW_BORDER_EXPLANATION(NewBorder_Explanation.FRENCH),

	NEW_BORDER_NAME_IS_MISSING(NewBorder_NameIsMissing.FRENCH),

	NEW_BORDER_NAME_ALREADY_TAKEN(NewBorder_NameAlreadyTaken.FRENCH),

	NEW_BORDER_BORDER_CREATED(NewBorder_BorderCreated.FRENCH),

	CURRENT_BORDER_EXPLANATION(CurrentBorder_Explanation.FRENCH),

	CURRENT_BORDER_ON_CURRENT(CurrentBorder_OnCurrent.FRENCH),

	LOAD_BORDER_EXPLANATION(LoadBorder_Explanation.FRENCH),

	LOAD_BORDER_NAME_IS_MISSING(LoadBorder_NameIsMissing.FRENCH),

	LOAD_BORDER_BORDER_LOADED(LoadBorder_BorderLoaded.FRENCH),

	DELETE_BORDER_EXPLANATION(DeleteBorder_Explanation.FRENCH),

	DELETE_BORDER_NAME_IS_MISSING(DeleteBorder_NameIsMissing.FRENCH),

	DELETE_BORDER_DID_NOT_DELETE(DeleteBorder_DidNotDelete.FRENCH),

	DELETE_BORDER_BORDER_DELETED(DeleteBorder_BorderDeleted.FRENCH),

	LIST_BORDER_EXPLANATION(ListBorder_Explanation.FRENCH),

	LIST_BORDER_NO_ELEMENT(ListBorder_NoElement.FRENCH),

	LIST_BORDER_ONE_ELEMENT(ListBorder_OneElement.FRENCH),

	LIST_BORDER_SEVERAL_ELEMENTS(ListBorder_SeveralElements.FRENCH),

	RENAME_BORDER_EXPLANATION(RenameBorder_Explanation.FRENCH),

	RENAME_BORDER_NAME_IS_MISSING(RenameBorder_NameIsMissing.FRENCH),

	RENAME_BORDER_NAME_ALREADY_TAKEN(RenameBorder_NameAlreadyTaken.FRENCH),

	RENAME_BORDER_BORDER_RENAMED(RenameBorder_BorderRenamed.FRENCH),

	SAVE_BORDER_EXPLANATION(SaveBorder_Explanation.FRENCH),

	SAVE_BORDER_BORDER_SAVED(SaveBorder_BorderSaved.FRENCH),

	WORLD_BORDER_EXPLANATION(WorldBorder_Explanation.FRENCH),

	WORLD_BORDER_WORLD_NAME_IS_MISSING(WorldBorder_WorldNameIsMissing.FRENCH),

	WORLD_BORDER_WORLD_DEFINED(WorldBorder_WorldDefined.FRENCH),

	CENTER_BORDER_EXPLANATION(CenterBorder_Explanation.FRENCH),

	CENTER_BORDER_CENTER_DEFINED(CenterBorder_CenterDefined.FRENCH),

	INITIAL_BORDER_DIAMETER_EXPLANATION(InitialBorderDiameter_Explanation.FRENCH),

	INITIAL_BORDER_DIAMETER_ON_TAB_COMPLETE(InitialBorderDiameter_OnTabComplete.FRENCH),

	INITIAL_BORDER_DIAMETER_DIAMETER_IS_MISSING(InitialBorderDiameter_DiameterIsMissing.FRENCH),

	INITIAL_BORDER_DIAMETER_NEGATIVE_DIAMETER(InitialBorderDiameter_NegativeDiameter.FRENCH),

	INITIAL_BORDER_DIAMETER_DIAMETER_DEFINED(InitialBorderDiameter_DiameterDefined.FRENCH),

	FINAL_BORDER_DIAMETER_EXPLANATION(FinalBorderDiameter_Explanation.FRENCH),

	FINAL_BORDER_DIAMETER_ON_TAB_COMPLETE(FinalBorderDiameter_OnTabComplete.FRENCH),

	FINAL_BORDER_DIAMETER_DIAMETER_IS_MISSING(FinalBorderDiameter_DiameterIsMissing.FRENCH),

	FINAL_BORDER_DIAMETER_NEGATIVE_DIAMETER(FinalBorderDiameter_NegativeDiameter.FRENCH),

	FINAL_BORDER_DIAMETER_DIAMETER_DEFINED(FinalBorderDiameter_DiameterDefined.FRENCH),

	SPEED_BORDER_EXPLANATION(SpeedBorder_Explanation.FRENCH),

	SPEED_BORDER_ON_TAB_COMPLETE(SpeedBorder_OnTabComplete.FRENCH),

	SPEED_BORDER_SPEED_IS_MISSING(SpeedBorder_SpeedIsMissing.FRENCH),

	SPEED_BORDER_SPEED_IS_NEGATIVE(SpeedBorder_SpeedIsNegative.FRENCH),

	SPEED_BORDER_SPEED_DEFINED(SpeedBorder_SpeedDefined.FRENCH),

	START_TIME_BORDER_EXPLANATION(StartTimeBorder_Explanation.FRENCH),

	START_TIME_BORDER_TIME_IS_MISSING(StartTimeBorder_TimeIsMissing.FRENCH),

	START_TIME_BORDER_BORDER_MOVES_AT_THE_BEGINNING(StartTimeBorder_BorderMovesAtTheBeginning.FRENCH),

	START_TIME_BORDER_START_TIME_DEFINED(StartTimeBorder_StartTimeDefined.FRENCH),

	MOVE_TIME_BORDER_EXPLANATION(MoveTimeBorder_Explanation.FRENCH),

	MOVE_TIME_BORDER_TIME_IS_MISSING(MoveTimeBorder_TimeIsMissing.FRENCH);

	private IMessage source;

	private FrenchBorderMessages(IMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (FrenchBorderMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMessage getSource() {
		return source;
	}
}
