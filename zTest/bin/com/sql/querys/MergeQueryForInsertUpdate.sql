merge into FPS_PREFERENCE fps 
	using (select :emp_id emp_id, :pref_key pref_key, :pref_value pref_value, :modified_by modified_by from dual) d 
		on (fps.emp_id = d.emp_id and fps.pref_key = d.pref_key) 
	when matched then 
		update set fps.pref_value = d.pref_value, fps.modified_by = d.modified_by, fps.modified_date = sysdate 
	when not matched then 
		insert (fps.emp_id, fps.pref_key, fps.pref_value, fps.modified_by, fps.modified_date) 
		values (d.emp_id, d.pref_key, d.pref_value, d.modified_by, sysdate);