package com.yahoo.squidb.processor.plugins.defaults.properties.generators;

import com.yahoo.aptutils.model.CoreTypes;
import com.yahoo.aptutils.model.DeclaredTypeName;
import com.yahoo.aptutils.utils.AptUtils;
import com.yahoo.aptutils.writer.JavaFileWriter;
import com.yahoo.aptutils.writer.expressions.Expressions;
import com.yahoo.squidb.processor.data.ModelSpec;

import java.io.IOException;

import javax.lang.model.element.VariableElement;

/**
 * Special case of BasicLongPropertyGenerator specific to ROWID or INTEGER PRIMARY KEY properties that generates
 * the extra methods required for TableModels
 */
public class RowidPropertyGenerator extends BasicLongPropertyGenerator {

    public RowidPropertyGenerator(ModelSpec<?> modelSpec, String columnName, AptUtils utils) {
        super(modelSpec, columnName, utils);
    }

    public RowidPropertyGenerator(ModelSpec<?> modelSpec, String columnName,
            String propertyName, AptUtils utils) {
        super(modelSpec, columnName, propertyName, utils);
    }

    public RowidPropertyGenerator(ModelSpec<?> modelSpec, VariableElement field, AptUtils utils) {
        super(modelSpec, field, utils);
    }

    @Override
    public DeclaredTypeName getTypeForAccessors() {
        return CoreTypes.PRIMITIVE_LONG;
    }

    @Override
    protected void writeGetterBody(JavaFileWriter writer) throws IOException {
        writer.writeStatement(Expressions.returnExpr(Expressions.fromString("super.getRowId()")));
    }

    @Override
    protected void writeSetterBody(JavaFileWriter writer, String argName) throws IOException {
        writer.writeStringStatement("super.setRowId(" + argName + ")");
        writer.writeStringStatement("return this");
    }
}
