package com.example.demo.repository.reducer;

import com.example.demo.model.Customer;
import com.example.demo.model.Manager;
import org.jdbi.v3.core.result.LinkedHashMapRowReducer;
import org.jdbi.v3.core.result.RowView;

import java.util.ArrayList;
import java.util.Map;

public class ManagerCustomerReducer implements LinkedHashMapRowReducer<Integer, Manager> {

    @Override
    public void accumulate(Map<Integer, Manager> container, RowView rowView) {
        var manager = container.computeIfAbsent(rowView.getColumn("m_id", Integer.class),
                id -> rowView.getRow(Manager.class)
        );
        var managerId = rowView.getColumn("c_manager_id", Integer.class);
        if (manager.getCustomers() == null) {
            manager.setCustomers(new ArrayList<>());
        }
        manager.getCustomers().add(rowView.getRow(Customer.class));
    }
}
