import {Address} from "../address/address";

export interface Event {
    id: string;
    name: string;
    userId: string;
    nametag: string;
    nationality: string;
    gender: string;
    education: string;
    birth: string;
    homeAddress: Address;
    homePhone: string;
    cellphone: string;
    professionId: string;
    organization: string;
    department: string;
    role: string;
    workAddress: Address;
    workPhone: string;
    workCellphone: string;
    workEmail: string;
}
