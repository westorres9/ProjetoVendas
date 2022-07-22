import './styles.css';
import 'flatpickr/dist/themes/material_green.css';
import FlatPicker from 'react-flatpickr';
import flatpickrLib from 'flatpickr';
import {Portuguese} from 'flatpickr/dist/l10n/pt'


flatpickrLib.localize(Portuguese);

const Filter = () => {
    const onChangeDate = (dates:Date[]) => {
        console.log(dates);
    }
    return (
        <div className="filter-container base-card">
            <FlatPicker
            options={{
                mode: 'range',
                dateFormat: 'd/m/Y',
                showMonths: 2
            }}
            className="filter-input"
            onChange={onChangeDate} 
            placeholder="Selecione um periodo"
            />
        </div>
    );
}

export default Filter;