prompt PL/SQL Developer import file
prompt Created on 2019年10月8日 by admin
set feedback off
set define off
prompt Disabling triggers for REUSER...
alter table REUSER disable all triggers;
prompt Disabling triggers for TICKET...
alter table TICKET disable all triggers;
prompt Disabling foreign key constraints for TICKET...
alter table TICKET disable constraint FK_TICKET_USERNAME;
prompt Deleting TICKET...
delete from TICKET;
commit;
prompt Deleting REUSER...
delete from REUSER;
commit;
prompt Loading REUSER...
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('韦朝', '123', '韦朝英', '女', '广西壮族', '河池市', '1 ', '4523456565656', '成人', '嘻嘻i嘻嘻嘻嘻嘻嘻', to_date('02-02-1999', 'dd-mm-yyyy'));
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('aaa', '123', 'aab', '女', '广西壮族', '河池市', '1 ', '4523456565656', '成人', '嘻嘻i嘻嘻嘻嘻嘻嘻', to_date('02-02-1999', 'dd-mm-yyyy'));
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('aaaa', '123', 'ss', null, null, null, null, null, null, null, null);
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('h', '12', 'hhhh', '男', '省份', '城市', '1 ', '45456435345', '成人', 'sdfdsf哈哈哈哈', to_date('02-02-1999', 'dd-mm-yyyy'));
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('weichaoying', '123456', 'wcy', '女', '广西壮族', '河池市', '1 ', '4523456565656', '成人', '嘻嘻i嘻嘻嘻嘻嘻嘻', to_date('05-02-1999', 'dd-mm-yyyy'));
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('weicy', '123', 'weichaoying', '男', '省份', '城市', '1 ', '4523456565656', '成人', 'hahhahahahahahahahha', to_date('02-02-1999', 'dd-mm-yyyy'));
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('haha', '123', '哈哈', '男', '广西壮族', '河池市', '1 ', '4523456565656', '成人', '嘻嘻i嘻嘻嘻嘻嘻嘻', to_date('02-02-1999', 'dd-mm-yyyy'));
insert into REUSER (renames, repass, retruename, sex, province, city, cardtpye, idnumber, passengertype, tips, borthday)
values ('user', '123', 'trueuser', '女', '广西壮族', '河池市', '1 ', '4523456565656', '成人', null, null);
commit;
prompt 8 records loaded
prompt Loading TICKET...
insert into TICKET (ticketid, startstation, endstation, startdate, starttime, renames)
values (201949, '南宁', '深圳', to_date('15-10-2019', 'dd-mm-yyyy'), to_date('15-10-2019 14:04:34', 'dd-mm-yyyy hh24:mi:ss'), '韦朝');
insert into TICKET (ticketid, startstation, endstation, startdate, starttime, renames)
values (201923, '广州南', '深圳', to_date('17-10-2019', 'dd-mm-yyyy'), to_date('17-10-2019 12:20:30', 'dd-mm-yyyy hh24:mi:ss'), 'h');
insert into TICKET (ticketid, startstation, endstation, startdate, starttime, renames)
values (201944, '南宁', '广州南', to_date('08-10-2019', 'dd-mm-yyyy'), to_date('08-10-2019 13:55:22', 'dd-mm-yyyy hh24:mi:ss'), 'haha');
insert into TICKET (ticketid, startstation, endstation, startdate, starttime, renames)
values (201947, '柳州', '广州南', to_date('09-10-2019', 'dd-mm-yyyy'), to_date('09-10-2019 14:02:58', 'dd-mm-yyyy hh24:mi:ss'), 'weicy');
insert into TICKET (ticketid, startstation, endstation, startdate, starttime, renames)
values (201948, '深圳', '广州南', to_date('27-10-2019', 'dd-mm-yyyy'), to_date('27-10-2019 14:04:07', 'dd-mm-yyyy hh24:mi:ss'), 'weichaoying');
insert into TICKET (ticketid, startstation, endstation, startdate, starttime, renames)
values (201941, '广州南', '柳州', to_date('08-10-2019', 'dd-mm-yyyy'), to_date('08-10-2019 10:53:14', 'dd-mm-yyyy hh24:mi:ss'), '韦朝');
commit;
prompt 6 records loaded
prompt Enabling foreign key constraints for TICKET...
alter table TICKET enable constraint FK_TICKET_USERNAME;
prompt Enabling triggers for REUSER...
alter table REUSER enable all triggers;
prompt Enabling triggers for TICKET...
alter table TICKET enable all triggers;
set feedback on
set define on
prompt Done.
